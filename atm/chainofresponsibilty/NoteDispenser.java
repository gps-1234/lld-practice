abstract class NoteDispenser implements DispenseChain{
    private DispenseChain nextChain;
    private final int noteValue;
    private int numNotes;

    public NoteDispenser(int noteValue,int numNotes){
         this.noteValue;
         this.numNotes=numNotes;
    }
    @Override
    public void setNextChain(DispenseChain nextChain){
        this.nextChain=nextChain;
    }
    @Override
    public void dispenseCash(int amount){
        if(amount>=noteValue){
            int noofnotes=min(amount/noteValue,numNotes);
            int remamt=amount-noofnotes*noteValue;
            if(remamt>0){
                if(this.nextChain!=null){
                    this.nextChain.dispenseCash(remamt);
                }
            }
        }
        else if(this.nextChain!=NULL){
            this.nextChain.dispenseCash(amount);
        }
    }
    @Override
    public void canDispense(int amount){
        if(amount>=noteValue){
            int noofnotes=min(amount/noteValue,numNotes);
            int remamt=amount-noofnotes*noteValue;
            if(remamt>0){
                if(this.nextChain!=null){
                    return this.nextChain.dispenseCash(remamt);
                }
            }
            return true;
        }
        else if(this.nextChain!=NULL){
           return this.nextChain.canDispense(amount);
        }
        return false;
    }



}