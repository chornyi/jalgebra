package com.mdgeorge.algebra.properties;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

import com.mdgeorge.algebra.properties.meta.annotation.MagicProperty;
import com.mdgeorge.algebra.properties.meta.annotation.MethodName;
import com.mdgeorge.util.OpBinary;

@Target(ElementType.METHOD)
@Documented
@MagicProperty
public @interface AntiSymmetric {
	@MethodName String eq() default "eq";
	
	public static class Definition {
		public static<E>
		boolean check ( OpBinary<E,E,Boolean> m
		              , OpBinary<E,E,Boolean> eq
		              , E a, E b
		              )
		{
			return m.ap(a, b) && m.ap(b, a)
			     ? eq.ap(a, b)
			     : true;
		}
	}
}
