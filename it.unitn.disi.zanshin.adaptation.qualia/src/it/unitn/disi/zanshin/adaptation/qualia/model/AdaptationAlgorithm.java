package it.unitn.disi.zanshin.adaptation.qualia.model;

import it.unitn.disi.zanshin.adaptation.qualia.Activator;
import it.unitn.disi.zanshin.adaptation.qualia.QualiaUtils;

import java.util.List;

/**
 * TODO: document this type.
 * 
 * @author Vitor E. Silva Souza (vitorsouza@gmail.com)
 * @version 1.0
 */
public class AdaptationAlgorithm {
	/** TODO: document this field. */
	private static final String DEFAULT_PARAMETER_CHOICE_PROCEDURE_ID = "random-single-parameter-choice"; //$NON-NLS-1$

	/** TODO: document this field. */
	private static final String DEFAULT_VALUE_CALCULATION_PROCEDURE_ID = "simple-value-calculation"; //$NON-NLS-1$

	/** TODO: document this field. */
	private static final String DEFAULT_PARAMETER_CHANGE_PROCEDURE_ID = "simple-parameter-change"; //$NON-NLS-1$

	/** TODO: document this field. */
	private static final String DEFAULT_WAITING_PROCEDURE_ID = "default-waiting"; //$NON-NLS-1$

	/** TODO: document this field. */
	private static final String DEFAULT_INDICATOR_EVALUATION_PROCEDURE_ID = "boolean-indicator-evaluation"; //$NON-NLS-1$

	/** TODO: document this field. */
	private static final String DEFAULT_LEARNING_PROCEDURE_ID = "no-learning"; //$NON-NLS-1$

	/** TODO: document this field. */
	private static final String DEFAULT_RESOLUTION_CHECK_PROCEDURE_ID = "simple-resolution-check"; //$NON-NLS-1$

	/** TODO: document this field. */
	private static final String DEFAULT_ALGORITHM_REASSESSMENT_PROCEDURE_ID = "no-algorithm-reassessment"; //$NON-NLS-1$

	/** TODO: document this field. */
	private ParameterChoiceProcedure parameterChoiceProcedure;

	/** TODO: document this field. */
	private ValueCalculationProcedure valueCalculationProcedure;

	/** TODO: document this field. */
	private ParameterChangeProcedure parameterChangeProcedure;

	/** TODO: document this field. */
	private WaitingProcedure waitingProcedure;

	/** TODO: document this field. */
	private IndicatorEvaluationProcedure indicatorEvaluationProcedure;

	/** TODO: document this field. */
	private LearningProcedure learningProcedure;

	/** TODO: document this field. */
	private ResolutionCheckProcedure resolutionCheckProcedure;

	/** TODO: document this field. */
	private AlgorithmReassessmentProcedure algorithmReassessmentProcedure;

	/** Constructor. Assembles the default algorithm. */
	public AdaptationAlgorithm() {
		QualiaUtils.log.debug("Creating a default algorithm..."); //$NON-NLS-1$
		
		// Assembles the default algorithm.
		parameterChoiceProcedure = Activator.retrieveProcedure(DEFAULT_PARAMETER_CHOICE_PROCEDURE_ID).as(ParameterChoiceProcedure.class);
		valueCalculationProcedure = Activator.retrieveProcedure(DEFAULT_VALUE_CALCULATION_PROCEDURE_ID).as(ValueCalculationProcedure.class);
		parameterChangeProcedure = Activator.retrieveProcedure(DEFAULT_PARAMETER_CHANGE_PROCEDURE_ID).as(ParameterChangeProcedure.class);
		waitingProcedure = Activator.retrieveProcedure(DEFAULT_WAITING_PROCEDURE_ID).as(WaitingProcedure.class);
		indicatorEvaluationProcedure = Activator.retrieveProcedure(DEFAULT_INDICATOR_EVALUATION_PROCEDURE_ID).as(IndicatorEvaluationProcedure.class);
		learningProcedure = Activator.retrieveProcedure(DEFAULT_LEARNING_PROCEDURE_ID).as(LearningProcedure.class);
		resolutionCheckProcedure = Activator.retrieveProcedure(DEFAULT_RESOLUTION_CHECK_PROCEDURE_ID).as(ResolutionCheckProcedure.class);
		algorithmReassessmentProcedure = Activator.retrieveProcedure(DEFAULT_ALGORITHM_REASSESSMENT_PROCEDURE_ID).as(AlgorithmReassessmentProcedure.class);
	}

	/** Constructor. Assembles the default algorithm and replaces some procedures, given their IDs. */
	public AdaptationAlgorithm(List<String> procedureIds) {
		this();
		
		// Retrieves the procedures and has them replace a default one.
		for (String id : procedureIds) {
			Procedure procedure = Activator.retrieveProcedure(id);
			if (procedure != null)
				procedure.replaceDefaultProcedure(this);
			else
				QualiaUtils.log.warn("Procedure not found: {0}", id); //$NON-NLS-1$
		}
	}
	
	/** Getter for parameterChoiceProcedure. */
	protected ParameterChoiceProcedure getParameterChoiceProcedure() {
		return parameterChoiceProcedure;
	}

	/** Setter for parameterChoiceProcedure. */
	protected void setParameterChoiceProcedure(ParameterChoiceProcedure parameterChoiceProcedure) {
		QualiaUtils.log.debug("Replacing Parameter Choice procedure: {0} -> {1}", this.parameterChoiceProcedure, parameterChoiceProcedure); //$NON-NLS-1$
		this.parameterChoiceProcedure = parameterChoiceProcedure;
	}

	/** Getter for valueCalculationProcedure. */
	protected ValueCalculationProcedure getValueCalculationProcedure() {
		return valueCalculationProcedure;
	}

	/** Setter for valueCalculationProcedure. */
	protected void setValueCalculationProcedure(ValueCalculationProcedure valueCalculationProcedure) {
		QualiaUtils.log.debug("Replacing Value Calculation procedure: {0} -> {1}", this.valueCalculationProcedure, valueCalculationProcedure); //$NON-NLS-1$
		this.valueCalculationProcedure = valueCalculationProcedure;
	}

	/** Getter for parameterChangeProcedure. */
	protected ParameterChangeProcedure getParameterChangeProcedure() {
		return parameterChangeProcedure;
	}

	/** Setter for parameterChangeProcedure. */
	protected void setParameterChangeProcedure(ParameterChangeProcedure parameterChangeProcedure) {
		QualiaUtils.log.debug("Replacing Parameter Change procedure: {0} -> {1}", this.parameterChangeProcedure, parameterChangeProcedure); //$NON-NLS-1$
		this.parameterChangeProcedure = parameterChangeProcedure;
	}

	/** Getter for waitingProcedure. */
	protected WaitingProcedure getWaitingProcedure() {
		return waitingProcedure;
	}

	/** Setter for waitingProcedure. */
	protected void setWaitingProcedure(WaitingProcedure waitingProcedure) {
		QualiaUtils.log.debug("Replacing Waiting procedure: {0} -> {1}", this.waitingProcedure, waitingProcedure); //$NON-NLS-1$
		this.waitingProcedure = waitingProcedure;
	}

	/** Getter for indicatorEvaluationProcedure. */
	protected IndicatorEvaluationProcedure getIndicatorEvaluationProcedure() {
		return indicatorEvaluationProcedure;
	}

	/** Setter for indicatorEvaluationProcedure. */
	protected void setIndicatorEvaluationProcedure(IndicatorEvaluationProcedure indicatorEvaluationProcedure) {
		QualiaUtils.log.debug("Replacing Indicator Evaluation procedure: {0} -> {1}", this.indicatorEvaluationProcedure, indicatorEvaluationProcedure); //$NON-NLS-1$
		this.indicatorEvaluationProcedure = indicatorEvaluationProcedure;
	}

	/** Getter for learningProcedure. */
	protected LearningProcedure getLearningProcedure() {
		return learningProcedure;
	}

	/** Setter for learningProcedure. */
	protected void setLearningProcedure(LearningProcedure learningProcedure) {
		QualiaUtils.log.debug("Replacing Learning procedure: {0} -> {1}", this.learningProcedure, learningProcedure); //$NON-NLS-1$
		this.learningProcedure = learningProcedure;
	}

	/** Getter for resolutionCheckProcedure. */
	protected ResolutionCheckProcedure getResolutionCheckProcedure() {
		return resolutionCheckProcedure;
	}

	/** Setter for resolutionCheckProcedure. */
	protected void setResolutionCheckProcedure(ResolutionCheckProcedure resolutionCheckProcedure) {
		QualiaUtils.log.debug("Replacing Resolution Check procedure: {0} -> {1}", this.resolutionCheckProcedure, resolutionCheckProcedure); //$NON-NLS-1$
		this.resolutionCheckProcedure = resolutionCheckProcedure;
	}

	/** Getter for algorithmReassessmentProcedure. */
	protected AlgorithmReassessmentProcedure getAlgorithmReassessmentProcedure() {
		return algorithmReassessmentProcedure;
	}

	/** Setter for algorithmReassessmentProcedure. */
	protected void setAlgorithmReassessmentProcedure(AlgorithmReassessmentProcedure algorithmReassessmentProcedure) {
		QualiaUtils.log.debug("Replacing Algorithm Reassessment procedure: {0} -> {1}", this.algorithmReassessmentProcedure, algorithmReassessmentProcedure); //$NON-NLS-1$
		this.algorithmReassessmentProcedure = algorithmReassessmentProcedure;
	}


	
	
	// FIXME: implement the methods below. Will require the definition of their signatures (depending on the procedures).

	public void chooseParameters() {
		System.out.println(parameterChoiceProcedure);
	}

	public void calculateValues() {
		System.out.println(valueCalculationProcedure);
	}

	public void changeParameters() {
		System.out.println(parameterChangeProcedure);
	}

	public void waitForEvaluation() {
		System.out.println(waitingProcedure);
	}

	public void evaluateIndicators() {
		System.out.println(indicatorEvaluationProcedure);
	}

	public void learn() {
		System.out.println(learningProcedure);
	}

	public void checkResolution() {
		System.out.println(resolutionCheckProcedure);
	}

	public void reassessAlgorithm() {
		System.out.println(algorithmReassessmentProcedure);
	}
}