/**
 * 创建时间：2014-7-9 下午8:12:23
 * @author Zheng Xinwei
 * @since 1.0
 * @version 1.0<br>
 */
package com.smartlife.model;

/**
 * 任务的实体类。<br>
 * 由于内部成员存在7个，其中有5个可以为默认，因此使用构造器模式<br>
 * 可以为默认的成员有： <br>
 * <b>isFinish</b> 默认为未结束<br>
 * <b>isGroupTask</b> 默认不为小组任务<br>
 * <b>isReminded</b> 默认不提醒<br>
 * <b>frequence</b> 默认频率为不重复<br>
 * <b>taskEndTime</b> 如果未设置默认为startTime</br>
 * */
public class Task {

	/** 频率的枚举变量 */
	enum Frequence {
		NONE_REPEAT, EACH_DAY, EACH_WEEK
	}

	/** 任务是否结束 */
	protected boolean isFinish;
	/** 是否小组任务 */
	protected boolean isGroupTask;
	/** 是否提醒 */
	protected boolean isReminded;
	/** 任务的开始时间 */
	protected String taskStartTime;
	/** 任务的结束时间 */
	protected String taskEndTime;
	/** 任务的频率 */
	protected Frequence frequence;
	/** 任务的内容 */
	protected String taskContent;

	private Task(Builder builder) {
		this.isFinish = builder.isFinish;
		this.isGroupTask = builder.isGroupTask;
		this.taskStartTime = builder.taskStartTime;
		this.taskEndTime = builder.taskEndTime;
		this.taskContent = builder.taskContent;
		this.isReminded = builder.isReminded;
		this.frequence = Frequence.NONE_REPEAT;
	}

	/** Task的构造器 */
	public static class Builder {
		String taskContent;
		String taskStartTime;

		// 可选参数
		Frequence frequence = Frequence.NONE_REPEAT;
		boolean isGroupTask = false;
		boolean isReminded = false;
		boolean isFinish = false;
		String taskEndTime;

		public Builder(String taskContent, String taskStartTime) {
			this.taskContent = taskContent;
			this.taskStartTime = taskStartTime;
		}

		public Builder frequence(Frequence frequence) {
			this.frequence = frequence;
			return this;
		}

		public Builder isReminded(boolean isReminded) {
			this.isReminded = isReminded;
			return this;
		}

		public Builder isGroupTask(boolean isGroupTask) {
			this.isGroupTask = isGroupTask;
			return this;
		}

		public Builder taskEndTime(String taskEndTime) {
			this.taskEndTime = taskEndTime;
			return this;
		}

		public Task build() {
			if (taskEndTime == null)
				taskEndTime = taskStartTime;
			return new Task(this);
		}
	}

	public boolean isGroupTask() {
		return isGroupTask;
	}

	public void setGroupTask(boolean isGroupTask) {
		this.isGroupTask = isGroupTask;
	}

	public boolean isReminded() {
		return isReminded;
	}

	public void setReminded(boolean isReminded) {
		this.isReminded = isReminded;
	}

	public String getTaskStartTime() {
		return taskStartTime;
	}

	public void setTaskStartTime(String taskStartTime) {
		this.taskStartTime = taskStartTime;
	}

	public String getTaskEndTime() {
		return taskEndTime;
	}

	public void setTaskEndTime(String taskEndTime) {
		this.taskEndTime = taskEndTime;
	}

	public Frequence getFrequence() {
		return frequence;
	}

	public void setFrequence(Frequence frequence) {
		this.frequence = frequence;
	}

	public String getTaskContent() {
		return taskContent;
	}

	public void setTaskContent(String taskContent) {
		this.taskContent = taskContent;
	}

	public boolean isFinish() {
		return isFinish;
	}

	public void setFinish(boolean isFinish) {
		this.isFinish = isFinish;
	}

	/**
	 * 创建一个测试用的Task实例
	 */
	public static Task newInstance() {
		return new Task.Builder("I'm Task~!", "20:00").build();
	}

}
