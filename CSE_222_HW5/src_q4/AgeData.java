class AgeData implements Comparable<AgeData> {
    private int age;
    private int numberOfPeople;

    AgeData(int age){
        setAge(age);
        setNumberOfPeople(1);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

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

    @Override
    public boolean equals(Object obj) {
        AgeData temp = (AgeData) obj;
        return this.getAge() == temp.getAge();
    }

    @Override
    public String toString(){
        return getAge() + " - " + getNumberOfPeople();
    }
}