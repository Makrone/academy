package by.academy.homework.homework7;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.util.NoSuchElementException;

public class Testing {

	public static void main(String[] args) {
		User user = new User("Максим", "Максимов", 18, LocalDate.of(1912, 02, 06), "admin", "password",
				"administrator@mhotmail.com");

		Class<User> userClass = User.class;
		Class<? super User> userSuperClass = userClass.getSuperclass();

		try {
			Method userGetLogin = userClass.getMethod("getLogin");
			System.out.println(userGetLogin.toString());
		} catch (NoSuchElementException | NoSuchMethodException e) {
			System.err.println(e.getMessage());
		}

		Method[] methodsUser = userClass.getMethods();
		for (Method method : methodsUser) {
			System.out.println(method.toString());
		}

		try {
			Field fieldLogin = userClass.getField("login");
			System.out.println(fieldLogin.toString());
		} catch (NoSuchFieldException e) {
			System.out.println(e.getMessage());
		}

		Field[] fieldsUser = userClass.getFields();
		for (Field field : fieldsUser) {
			System.out.println(field.toString());
		}

		try {
			Method userGetLogin = userClass.getDeclaredMethod("getLogin");
			System.out.println(userGetLogin.toString());
		} catch (NoSuchElementException | NoSuchMethodException e) {
			System.err.println(e.getMessage());
		}
		System.out.println("-------------------");

		Method[] declaredMethodsUser = userClass.getDeclaredMethods();
		for (Method method : declaredMethodsUser) {
			System.out.println(method.toString());
		}
		Method[] declaredMethodsUserSuper = userSuperClass.getDeclaredMethods();
		for (Method method : declaredMethodsUserSuper) {
			System.out.println(method.toString());
		}

		try {
			Field fieldLogin = userClass.getDeclaredField("login");
			System.out.println(fieldLogin.toString());
		} catch (NoSuchFieldException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("-------------------");

		Field[] declaredFieldsUser = userClass.getDeclaredFields();
		for (Field field : declaredFieldsUser) {
			System.out.println(field.toString());
		}
		Field[] declaredFieldsUserSuper = userSuperClass.getDeclaredFields();
		for (Field field : declaredFieldsUserSuper) {
			System.out.println(field.toString());
		}
		System.out.println("-------------------");

		try {
			Field[] declaredFieldsUserValue = userClass.getDeclaredFields();
			for (Field field : declaredFieldsUserValue) {
				field.setAccessible(true);
				System.out.println(field.get(user));
			}
			Field[] declaredFieldsUserSuperValue = userSuperClass.getDeclaredFields();
			for (Field field : declaredFieldsUserSuperValue) {
				field.setAccessible(true);
				System.out.println(field.get(user));
			}
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

	}

}
