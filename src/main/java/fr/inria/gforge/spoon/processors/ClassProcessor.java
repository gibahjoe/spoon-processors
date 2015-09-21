package fr.inria.gforge.spoon.processors;

import spoon.processing.AbstractProcessor;
import spoon.reflect.code.CtBlock;
import spoon.reflect.code.CtCodeSnippetStatement;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtConstructor;
import spoon.reflect.declaration.CtField;
import spoon.reflect.declaration.CtParameter;
import spoon.reflect.declaration.ModifierKind;
import spoon.reflect.reference.CtTypeReference;

import java.util.Collections;
import java.util.Date;
import java.util.List;

public class ClassProcessor extends AbstractProcessor<CtClass<?>> {
	@Override
	public void process(CtClass<?> ctClass) {
		// Creates field.
		final CtTypeReference<Date> dateRef =
				getFactory()
						.Code()
						.createCtTypeReference(Date.class);
		final CtTypeReference<List<Date>> listRef =
				getFactory()
						.Code()
						.createCtTypeReference(List.class)
						.addActualTypeArgument(dateRef);
		final CtField<List<Date>> listOfDates =
				getFactory()
						.Core()
						.<List<Date>>createField()
						.<CtField>setType(listRef)
						.<CtField>addModifier(ModifierKind.PRIVATE)
						.setSimpleName("dates");

		// Creates constructor.
		final CtCodeSnippetStatement statementInConstructor =
				getFactory()
						.Code()
						.createCodeSnippetStatement("this.dates = dates");
		final CtBlock<?> ctBlockOfConstructor =
				getFactory()
						.Code()
						.createCtBlock(statementInConstructor);
		final CtParameter<List<Date>> parameter =
				getFactory()
						.Core()
						.<List<Date>>createParameter()
						.<CtParameter>setType(listRef)
						.setSimpleName("dates");
		final CtConstructor constructor =
				getFactory()
						.Core()
						.createConstructor()
						.setBody(ctBlockOfConstructor)
						.<CtConstructor>setParameters(
								Collections.<CtParameter<?>>singletonList(parameter))
						.addModifier(ModifierKind.PUBLIC);

		// Apply transformation.
		ctClass.addField(listOfDates);
		ctClass.addConstructor(constructor);
	}
}
