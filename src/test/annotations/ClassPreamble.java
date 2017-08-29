package test.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* use documented in order to the information of this annotations appears in the javadoc generated documentations*/
@Documented
@Retention(RetentionPolicy.SOURCE)//this tag will be retained only by the source code
///@Target(ElementType.CONSTRUCTOR)//the marked tag will be used only in a constructor
public @interface ClassPreamble {
	String author();

	String date();

	int currentRevision() default 1;

	String lastModified() default "N/A";

	String lastModifiedBy() default "N/A";

	// Note use of array
	String[] reviewers();
}