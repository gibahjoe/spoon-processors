package fr.inria.gforge.spoon.templates;

import spoon.reflect.declaration.CtType;
import spoon.reflect.reference.CtTypeReference;
import spoon.template.AbstractTemplate;
import spoon.template.Local;
import spoon.template.Parameter;
import spoon.template.Substitution;

import java.util.List;

public class ClassTemplate extends AbstractTemplate<CtType<?>> {
	@Parameter
	CtTypeReference<?> _Type_;

	@Local
	public ClassTemplate(CtTypeReference<?> type) {
		this._Type_ = type;
	}

	@Override
	@Local
	public CtType<?> apply(CtType<?> ctType) {
		Substitution.insertAll(ctType, this);
		return ctType;
	}

	private List<_Type_> list;

	public ClassTemplate(List<_Type_> dates) {
		this.list = dates;
	}

	public List<_Type_> getList() {
		return list;
	}

	public void setList(List<_Type_> list) {
		this.list = list;
	}
}

interface _Type_ {
}