package toby.querydsl.domain.enums.base;

import org.apache.commons.lang.ArrayUtils;

public interface IntegerBaseEnumInterface {

	/**
	 * 获取枚举的存储值
	 * 
	 * @return
	 */
	Integer getCode();

	/**
	 * 获取枚举的标记字符串
	 * 
	 * @return
	 */
	String getLabel();

	@SuppressWarnings("unchecked")
	static <T extends IntegerBaseEnumInterface> T getEnum(Class<T> enumClass, Integer value) {

		if (!enumClass.isAssignableFrom(IntegerBaseEnumInterface.class)) {
			throw new IllegalArgumentException("参数非法");
		}

		IntegerBaseEnumInterface[] enumsConstants = (IntegerBaseEnumInterface[]) enumClass.getEnumConstants();
		if (ArrayUtils.isEmpty(enumsConstants)) {
			throw new IllegalArgumentException("参数非法");
		}

		for (IntegerBaseEnumInterface integerBaseEnumInterface : enumsConstants) {
			
			if (integerBaseEnumInterface.getCode().equals(value)) {
				return (T) integerBaseEnumInterface;
			}
		}

		throw new IllegalArgumentException("参数非法");
	}
}
