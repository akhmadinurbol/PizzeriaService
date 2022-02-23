package com.company.state;

public class OrderState {

    public Activity activity;

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public void changeActivity(){
        if (activity instanceof AcceptOrder){
            setActivity(new PrepareOrder());
        }else if (activity instanceof PrepareOrder){
            setActivity(new ReadyOrder());
        }
    }

    public void makeOrder(){
        activity.makeOrder();
    }
}
