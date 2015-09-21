package fr.inria.gforge.spoon.processors;

import fr.inria.gforge.spoon.templates.ClassTemplate;
import spoon.processing.AbstractProcessor;
import spoon.reflect.declaration.CtClass;

import java.util.Date;

public class ClassWithTemplateProcessor extends AbstractProcessor<CtClass<?>> {
	@Override
	public void process(CtClass<?> ctClass) {
		new ClassTemplate(getFactory().Code().createCtTypeReference(Date.class)).apply(ctClass);
	}
}
