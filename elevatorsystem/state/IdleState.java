public IdleState implements ElevatorState{
    @Override
            public void move(Elevator e){
        if(e.getUpRequest==null && e.getDownRequests==null){
            e.setCurrentState()
        }
    }
}