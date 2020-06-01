public class Software {
    /**
     * Name of the author
     */
    private String nameOfSoftware;
    /**
     * Title of the book
     */
    private Double versionOfSoftware;
    /**
     * Location of the book that is located
     */
    private Integer quantityOfSoftware;
    /**
     * Location of the book that is located
     */
    private Double priceOfSoftware;

    /**
     * @return the nameOfSoftware
     */
    public String getNameOfSoftware() {
        return nameOfSoftware;
    }

    /**
     * @param nameOfSoftware the nameOfSoftware to set
     */
    public void setNameOfSoftware(String nameOfSoftware) {
        this.nameOfSoftware = nameOfSoftware;
    }

    /**
     * @return the versionOfSoftware
     */
    public Double getVersionOfSoftware() {
        return versionOfSoftware;
    }

    /**
     * @param versionOfSoftware the versionOfSoftware to set
     */
    public void setVersionOfSoftware(Double versionOfSoftware) {
        this.versionOfSoftware = versionOfSoftware;
    }

    /**
     * @return the quantityOfSoftware
     */
    public Integer getQuantityOfSoftware() {
        return quantityOfSoftware;
    }

    /**
     * @param quantityOfSoftware the quantityOfSoftware to set
     */
    public void setQuantityOfSoftware(Integer quantityOfSoftware) {
        this.quantityOfSoftware = quantityOfSoftware;
    }

    /**
     * @return the priceOfSoftware
     */
    public Double getPriceOfSoftware() {
        return priceOfSoftware;
    }

    /**
     * @param priceOfSoftware the priceOfSoftware to set
     */
    public void setPriceOfSoftware(Double priceOfSoftware) {
        this.priceOfSoftware = priceOfSoftware;
    }

	/**
	 * @param nameOfSoftware
	 * @param versionOfSoftware
	 * @param quantityOfSoftware
	 * @param priceOfSoftware
	 */
	public Software(String nameOfSoftware, Double versionOfSoftware, Integer quantityOfSoftware,
			Double priceOfSoftware) {
		this.nameOfSoftware = nameOfSoftware;
		this.versionOfSoftware = versionOfSoftware;
		this.quantityOfSoftware = quantityOfSoftware;
		this.priceOfSoftware = priceOfSoftware;
	}

}
