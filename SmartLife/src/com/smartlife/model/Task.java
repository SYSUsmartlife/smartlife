/**
 * 创建时间：2014-7-9 下午8:12:23
 * @author Zheng Xinwei
 * @since 1.0
 * @version 1.0<br>
 */
package com.smartlife.model;

/**
 * 任务的实体类。<br>
 * */
public class Task {

	/** 是否小组任务 */
	protected boolean isGroupTask = false;
	/** 是否提醒 */
	protected boolean isReminded = false;
	/** 任务的开始时间 */
	protected String taskStartTime = "00:00";
	/** 任务的结束时间 */
	protected String taskEndTime = "00:00";
	/** 任务的频率 */
	protected Frequence frequence = Frequence.NONE_REPEAT;
	/** 任务的内容 */
	protected String taskContent = null;

	public Task() {

	}

	enum Frequence {
		NONE_REPEAT, EACH_DAY, EACH_WEEK
	}
}
