package com.cat;


public class Temp {
    public class AB{
        public void  isOwnedBy(Temp sync) {
            System.out.println(Temp.this);
            System.out.println(sync == Temp.this);
        }
    }


    public static void main(String[] args) {
        Temp temp = new Temp();
        AB ab = temp.new AB();
        ab.isOwnedBy(temp);
    }
}

