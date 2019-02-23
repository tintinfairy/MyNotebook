public class Note {
    private String date;
    private String information;
    private int numOfNote;

    Note(int numOfNote, String date, String information) {
        this.numOfNote = numOfNote;
        this.date = date;
        this.information = information;

    }

    public int getNumOfNote() {
        return numOfNote;
    }
    public String  getDate() {
        return date;
    }
    public String getInformation() {
        return information;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setNumOfNote(int numOfNote) {
        this.numOfNote = numOfNote;
    }


    public void setInformation(String information) {
        this.information = information;
    }

    @Override
    public String toString() {
        return (numOfNote + ": <" + date + "> " + information);
    }

}
