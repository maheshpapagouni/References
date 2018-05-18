

package com.java.Reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class Reference {

	public static void main(String[] args) {
		//strongReference();
		weakReference();
		softReference();
	}

	private static void strongreference() {
		Student student = new Student(10, "Strongreference");
		student = null; 
	}
	
	private static void weakReference() {
		Student student = new Student(11, "Weakreference");
		WeakReference<Student> weakReference = new WeakReference<Student>(student);
		System.out.println("Weak Reference before null :" +weakReference.get());
		student = null;
		System.gc();
		System.out.println("Weak Reference After Null: " +weakReference.get());
	}
	
	private static void softReference() {
		Student student = new Student(12, "Softreference");
		SoftReference<Student> softReference = new SoftReference<Student>(student);
		System.out.println("Soft reference before Null: " +softReference.get());
		student = null;
		System.gc();
		System.out.println("Soft Reference After Null:" +softReference.get());
	}
	
	private static void phantomReference() {
		Student student = new Student(13, "Phantomreference");
		ReferenceQueue<Student> referenceQueue = new ReferenceQueue<Student>();
		PhantomReference<Student> phantomReference = new PhantomReference<Student>(student, referenceQueue);
		System.out.println("Phantom Reference :");
		System.out.println(phantomReference.get());
		
	}
}