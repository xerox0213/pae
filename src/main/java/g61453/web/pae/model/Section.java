package g61453.web.pae.model;

public enum Section {
    APPLICATION("Application"), NETWORK("Réseau"), INDUSTRIAL("Industrielle");

    private final String label;

    Section(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
