package webService.soap.handbook.model;

public class DefenitionModel {
	private String nameDefenition;
	private String bodyDefenition;

	public DefenitionModel() {

	}

	public String getNameDefenition() {
		return nameDefenition;
	}

	public void setNameDefenition(String nameDefenition) {
		this.nameDefenition = nameDefenition;
	}

	public String getBodyDefenition() {
		return bodyDefenition;
	}

	public void setBodyDefenition(String bodyDefenition) {
		this.bodyDefenition = bodyDefenition;
	}

	@Override
	public String toString() {
		return "DefenitionModel [nameDefenition=" + nameDefenition + ", bodyDefenition=" + bodyDefenition + "]";
	}

}
