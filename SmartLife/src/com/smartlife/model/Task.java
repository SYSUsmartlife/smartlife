/**
 * 创建时间：2014-7-9 下午8:12:23
 * @author Zheng Xinwei
 * @since 1.0
 * @version 1.0<br>
 */
package com.smartlife.model;

import java.io.Serializable;

/**
 * 任务的实体类。<br>
 * 由于内部成员存在10个，其中有8个可以为默认，使用构造器模式<br>
 * 必须提供的参数:<br>
 * <b>taskTitle</b>, <b>taskStartTime</b><br>
 * 可以为默认的成员有： <br>
 * <b>isFinish</b> 默认为未结束<br>
 * <b>isGroupTask</b> 默认不为小组任务<br>
 * <b>isRemind</b> 默认不提醒<br>
 * <b>frequence</b> 默认频率为不重复<br>
 * <b>taskStartDate</b> 默认为当天 <b>taskEndDate</b> 默认为当天 <b>taskEndTime</b>
 * 如果未设置默认为startTime<br>
 * <b>taskContent</b> 如果未设置则默认为tasktitle</br>
 * */
public class Task implements Serializable {

	private static final long serialVersionUID = 20L;
	public static final String TAG = Task.class.getSimpleName();

	/** 频率的枚举变量 */
	public enum Frequence {
		NONE_REPEAT, EACH_DAY, EACH_WEEK
	}

	/** 任务是否结束 */
	protected boolean isFinish;
	/** 是否小组任务 */
	protected boolean isGroupTask;
	/** 是否提醒 */
	protected boolean isRemind;
	/** 任务的开始日期 */
	protected String taskStartDate;
	/** 任务的结束日期 */
	protected String taskEndDate;
	/** 任务的开始时间 */
	protected String taskStartTime;
	/** 任务的结束时间 */
	protected String taskEndTime;
	/** 任务的频率 */
	protected Frequence frequence;
	/** 任务的标题 */
	protected String taskTitle;
	/** 任务的内容 */
	protected String taskContent;

	private Task(Builder builder) {
		this.isFinish = builder.isFinish;
		this.isGroupTask = builder.isGroupTask;
		this.taskStartDate = builder.taskStartDate;
		this.taskEndDate = builder.taskEndDate;
		this.taskStartTime = builder.taskStartTime;
		this.taskEndTime = builder.taskEndTime;
		this.taskTitle = builder.taskTitle;
		this.taskContent = builder.taskContent;
		this.isRemind = builder.isRemind;
		this.frequence = builder.frequence;
	}

	/** Task的构造器 */
	public static class Builder {
		String taskTitle;
		String taskStartTime;

		// 可选参数
		Frequence frequence = Frequence.NONE_REPEAT;
		boolean isGroupTask = false;
		boolean isRemind = false;
		boolean isFinish = false;
		String taskStartDate;
		String taskEndDate;
		String taskEndTime;
		String taskContent;

		public Builder(String taskTitle, String taskStartTime) {
			this.taskTitle = taskTitle;
			this.taskStartTime = taskStartTime;
		}

		public Builder content(String content) {
			this.taskContent = content;
			return this;
		}

		public Builder frequence(Frequence frequence) {
			this.frequence = frequence;
			return this;
		}

		public Builder startDate(String startDate) {
			this.taskStartDate = startDate;
			return this;
		}

		public Builder endDate(String endDate) {
			this.taskEndDate = endDate;
			return this;
		}

		public Builder isRemind(boolean isRemind) {
			this.isRemind = isRemind;
			return this;
		}

		public Builder isGroupTask(boolean isGroupTask) {
			this.isGroupTask = isGroupTask;
			return this;
		}

		public Builder endTime(String taskEndTime) {
			this.taskEndTime = taskEndTime;
			return this;
		}

		public Task build() {
			if (taskEndTime == null)
				taskEndTime = taskStartTime;
			if (taskContent == null)
				taskContent = taskTitle;
			// TODO 获取当前日期
			if (taskStartDate == null)
				taskStartDate = "2014-12-3";
			if (taskEndDate == null)
				taskEndDate = "2014-12-3";
			return new Task(this);
		}
	}

	public boolean isFinish() {
		return isFinish;
	}

	public void setFinish(boolean isFinish) {
		this.isFinish = isFinish;
	}

	public boolean isGroupTask() {
		return isGroupTask;
	}

	public void setGroupTask(boolean isGroupTask) {
		this.isGroupTask = isGroupTask;
	}

	public boolean isRemind() {
		return isRemind;
	}

	public void setRemind(boolean isRemind) {
		this.isRemind = isRemind;
	}

	public String getTaskStartDate() {
		return taskStartDate;
	}

	public void setTaskStartDate(String taskStartDate) {
		this.taskStartDate = taskStartDate;
	}

	public String getTaskEndDate() {
		return taskEndDate;
	}

	public void setTaskEndDate(String taskEndDate) {
		this.taskEndDate = taskEndDate;
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

	public String getTaskTitle() {
		return taskTitle;
	}

	public void setTaskTitle(String taskTitle) {
		this.taskTitle = taskTitle;
	}

	public String getTaskContent() {
		return taskContent;
	}

	public void setTaskContent(String taskContent) {
		this.taskContent = taskContent;
	}

	/**
	 * 创建一个测试用的Task实例
	 */
	public static Task newInstance() {
		return new Task.Builder("I'm Task~!", "20:00").build();
	}

}
