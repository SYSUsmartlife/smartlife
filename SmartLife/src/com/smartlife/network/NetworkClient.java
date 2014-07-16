package com.smartlife.network;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import com.smartlife.network.params.BasicNetworkParams;

import android.os.Message;
import android.util.Log;

public class NetworkClient {

	private static volatile NetworkClient mSingleInstance;
	private HttpClient mHttpClient;

	private NetworkClient() {
		mHttpClient = new DefaultHttpClient();
	}

	public static NetworkClient getInstance() {
		if (mSingleInstance == null) {
			synchronized (NetworkClient.class) {
				if (mSingleInstance == null) {
					mSingleInstance = new NetworkClient();
				}
			}
		}
		return mSingleInstance;
	}

	public void request(final String url, final BasicNetworkParams params,
			final NetworkHandler handler) {
		new Thread() {

			@Override
			public void run() {
				Message msg = new Message();
				String returnString = "";
				try {
					HttpPost post = new HttpPost(url);
					post.setEntity(new UrlEncodedFormEntity(params
							.toNetworkParams(), HTTP.UTF_8));
					HttpResponse response = mHttpClient.execute(post);
					if (response.getStatusLine().getStatusCode() == 200) {
						returnString = EntityUtils.toString(response
								.getEntity());
						JSONObject json = new JSONObject(returnString);
						msg.what = NetworkConfig.CODE_RESPONSE_JSON;
						msg.obj = json;
					} else {
						msg.what = NetworkConfig.CODE_NETWORK_ERROR;
						msg.obj = NetworkConfig.MSG_NETWORK_ERROR + "返回码："
								+ response.getStatusLine().getStatusCode()
								+ "！";
					}
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
					msg.what = NetworkConfig.CODE_NETWORK_ERROR;
					msg.obj = NetworkConfig.MSG_ENCODING_ERROR;
				} catch (ClientProtocolException e) {
					e.printStackTrace();
					Log.i("SmartLife-Network", e.getMessage());
					msg.what = NetworkConfig.CODE_NETWORK_ERROR;
					msg.obj = NetworkConfig.MSG_NETWORK_ERROR;
				} catch (IOException e) {
					e.printStackTrace();
					Log.i("SmartLife-Network", e.getMessage());
					msg.what = NetworkConfig.CODE_NETWORK_ERROR;
					msg.obj = NetworkConfig.MSG_NETWORK_ERROR;
				} catch (JSONException e) {
					e.printStackTrace();
					msg.what = NetworkConfig.CODE_RESPONSE_ERROR;
					msg.obj = NetworkConfig.MSG_RESPONSE_ERROR;
					Log.i("json", "json" + returnString);
					Log.i("url", url);
				} finally {
					handler.sendMessage(msg);
				}
			}

		}.start();
	}

}
