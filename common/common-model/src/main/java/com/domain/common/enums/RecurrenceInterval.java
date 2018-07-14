package com.domain.common.enums;

/**
 * 重发间隔
 * 单位：秒
 */
public enum RecurrenceInterval {
	first(1, 1 ^ 2 * 60),
	second(2, 2 ^ 2 * 60),
	third(3, 3 ^ 2 * 60),
	forth(4, 4 ^ 2 * 60),
	fifth(5, 5 ^ 2 * 60);

	private Integer count;
	private Integer interval;

	RecurrenceInterval(Integer count, Integer interval) {
		this.count = count;
		this.interval = interval;
	}

	public Integer getCount() {
		return count;
	}

	public Integer getInterval() {
		return interval;
	}

	public static Integer getIntervalByCount(Integer count) {
		switch (count) {
			case 1:
				return first.getInterval();
			case 2:
				return second.getInterval();
			case 3:
				return third.getInterval();
			case 4:
				return forth.getInterval();
			case 5:
				return fifth.getInterval();
			default:
				return fifth.getInterval();
		}

	}
}
