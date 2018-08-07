package com.geekluxun.service.impl.bean;

/**
 * ID类型
 *
 * <P>根据时间的位数和序列号的位数,ID类型可分为最大峰值型和最小粒度型
 *
 * <p>最大峰值型能承受更大的峰值压力,但是粗略有序的粒度有点大
 * 最小粒度型有较细致的粒度,但是每个毫秒能承受的理论峰值有限,为1K,同一毫秒如果有更多的请求产生,必须等到下一个毫秒再响应
 *
 * <P> ID类型在配置时指定,目前需要重启服务才能相互切换(TODO: 动态切换)
 */
public enum IdType {
	/**
	 * 最大峰值型: 采用秒极有序，秒极时间占用30位,序列号占用20位
	 */
	MAX_PEAK("max-peak"),
	/**
	 * 最小粒度型: 采用毫秒级有序,毫秒级时间占用40位,序列号占用10位
	 */
	MIN_GRANULARITY("min-granularity");

	private String name;

	IdType(String name) {
		this.name = name;
	}

	public long value() {
		switch (this) {
		case MAX_PEAK:
			return 0;
		case MIN_GRANULARITY:
			return 1;
		default:
			return 0;
		}
	}

	@Override
	public String toString() {
		return this.name;
	}

	public static IdType parse(String name) {
		if ("min-granularity".equals(name))
			return MIN_GRANULARITY;
		else if ("max-peak".equals(name))
			return MAX_PEAK;

		return null;
	}

	public static IdType parse(long type) {
		if (type == 1)
			return MIN_GRANULARITY;
		else if (type == 0)
			return MAX_PEAK;

		return null;
	}
}
