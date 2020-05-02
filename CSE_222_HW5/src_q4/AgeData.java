class AgeData implements Comparable<AgeData> {
    /**
     * Age
     */
    private int age;
    /**
     * Number of people
     */
    private int numberOfPeople;

    /**
     * Constructor for Age Data
     * @param age Age that will be constructed
     */
    AgeData(int age){
        setAge(age);
        setNumberOfPeople(1);
    }

    /**
     * Getting Age
     * @return Age
     */
    public int getAge() {
        return age;
    }

    /**
     * Setting Age
     * @param age Age will be set
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Getting Number Of People
     * @return Number of people
     */
    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    /**
     * Setting Number Of People
     * @param numberOfPeople Number of people that will be set
     */
    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    /**
     * Comparing ages
     * @param o AgeData
     * @return if this age bigger than ther age, returns 1, otherwise returns -1,
     *         if equals, if method that is called is add, number of people will be increased and
     *         returns 0, if method that is called is delete, number of people will be decreased if
     *         number of people is bigger than 1 otherwise 0
     */
    @Override
    public int compareTo(AgeData o) {

        //for using compare ages
        if(Thread.currentThread().getStackTrace()[3].getMethodName().equals("youngerThan") ||
                Thread.currentThread().getStackTrace()[3].getMethodName().equals("olderThan")){
            return Integer.compare(this.getAge(), o.getAge());
        }
        //for using compare equal ages
        if(this.getAge() == o.getAge()){
            //call add then find method
            if(Thread.currentThread().getStackTrace()[3].getMethodName().equals("find") &&
                    Thread.currentThread().getStackTrace()[4].getMethodName().equals("add")){

                o.setNumberOfPeople(o.getNumberOfPeople() + 1);
                //call only find method
            } else if(Thread.currentThread().getStackTrace()[4].getMethodName().equals("remove")){
                //for deletion
                if(o.getNumberOfPeople() > 1){
                    o.setNumberOfPeople(o.getNumberOfPeople() - 1);
                    return -2;
                }
            }
            return 0;
        }
        else if(this.numberOfPeople > o.numberOfPeople ){
            return 1;
        }
        else {
            return -1;
        }
    }

    /**
     * Override equals method
     * @param obj object that will be compared
     * @return if this age is equal, returns true, otherwise false
     */
    @Override
    public boolean equals(Object obj) {
        AgeData temp = (AgeData) obj;
        return this.getAge() == temp.getAge();
    }

    /**
     * toString method
     * @return Age - Number of People String returns
     */
    @Override
    public String toString(){
        return getAge() + " - " + getNumberOfPeople();
    }
}