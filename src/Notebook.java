
public class Notebook {

    private int numberOfNotes = 10;
    private int currentNote = -1;
    private Note[] notes;
    private static final int MAGNIFIER = 2;


    public Notebook() {
        notes = new Note[numberOfNotes];
    }

    public Notebook(int numberOfNotes) {
        this.numberOfNotes = numberOfNotes;
        notes = new Note[numberOfNotes];
    }


    public void addNote(String date, String information) {
        currentNote++;
        if (currentNote < numberOfNotes) {
            notes[currentNote] = new Note(currentNote, date, information);
        } else {
            int newNumberOfNotes = MAGNIFIER * numberOfNotes;
            notes = changeNotebookSize(numberOfNotes, newNumberOfNotes);
            Note note = new Note(currentNote, date, information);
            notes[currentNote] = note;
            numberOfNotes = newNumberOfNotes;
        }
    }

    public void deleteNote(int numToDelete) {
        if (numToDelete > currentNote || numToDelete < 0) {
            System.out.println("There is no note with this number!!!");
        } else {
            int length = numberOfNotes - numToDelete - 1;
            Note[] newNotes = new Note[length];
            System.arraycopy(notes, numToDelete + 1, newNotes, 0, length);
            System.arraycopy(newNotes, 0, notes, numToDelete, length);
            for (int i = 0; i < numberOfNotes; i++) {
                if (notes[i] != null) {
                    currentNote = i;
                    notes[i].setNumOfNote(i);
                }
            }
            int newNumberOfNotes = numberOfNotes - currentNote;
            notes = changeNotebookSize(numberOfNotes, newNumberOfNotes);
            numberOfNotes = newNumberOfNotes;


        }
    }

    public void editNote(int numToEdit, String date, String information) {
        if (numToEdit > currentNote || numToEdit < 0) {
            System.out.println("There is no note with this number!!!");
        } else {
            notes[numToEdit].setDate(date);
            notes[numToEdit].setInformation(information);
        }
    }

    public String getNote(int numOfNote) {
        if (numOfNote > currentNote || numOfNote < 0) {
            return ("There is no note with this number!!!");
        }
        return notes[numOfNote].toString();

    }

    public void printAllNotes() {
        int i = 0;
        while (notes[i] != null) {
            System.out.println(notes[i].toString());
            i++;
        }

    }

    private Note[] changeNotebookSize(int oldSize, int newSize) {
        Note[] newNotes = notes.clone();
        notes = new Note[newSize];
        if (oldSize < newSize) {
            System.arraycopy(newNotes, 0, notes, 0, newNotes.length);
        } else {
            System.arraycopy(newNotes, 0, notes, 0, newNotes.length - 1);
        }
        return notes;
    }

}
