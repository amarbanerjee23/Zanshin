package it.unitn.disi.zanshin.adaptation.qualia.model;


/**
 * TODO: document this type.
 *
 * @author Vitor E. Silva Souza (vitorsouza@gmail.com)
 * @version 1.0
 */
public abstract class AbstractResolutionCheckProcedure extends AbstractProcedure implements ResolutionCheckProcedure {
	/** @see it.unitn.disi.zanshin.adaptation.qualia.model.Procedure#replaceDefaultProcedure(it.unitn.disi.zanshin.adaptation.qualia.model.AdaptationAlgorithm) */
	@Override
	public void replaceDefaultProcedure(AdaptationAlgorithm adaptationAlgorithm) {
		adaptationAlgorithm.setResolutionCheckProcedure(this);
	}
}
