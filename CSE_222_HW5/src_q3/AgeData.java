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
        if(this.age > o.age)
            return 1;
        else if(this.age < o.age){
            return -1;
        }else{
            if(Thread.currentThread().getStackTrace()[3].getMethodName().equals("add")){
                o.setNumberOfPeople(o.getNumberOfPeople() + 1);
            } else if(Thread.currentThread().getStackTrace()[3].getMethodName().equals("find")){
            } else if(Thread.currentThread().getStackTrace()[3].getMethodName().equals("delete")){
                if(o.getNumberOfPeople() > 1){
                    o.setNumberOfPeople(o.getNumberOfPeople() - 1);
                    return -2;
                }
            }
            return 0;
        }
    }


    @Override
    public String toString(){
        return getAge() + " - " + getNumberOfPeople();
    }
}