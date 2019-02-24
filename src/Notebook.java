
public class Notebook {

    private int notebookCapacity = 8;
    private int currentNote = -1;
    private Note[] notes;
    private static final int MAGNIFIER = 2;


    public Notebook() {
        notes = new Note[notebookCapacity];
    }

    public Notebook(int numberOfNotes) {
        this.notebookCapacity = numberOfNotes;
        notes = new Note[numberOfNotes];
    }


    public void addNote(String date, String information) {
        currentNote++;
        if (currentNote < notebookCapacity) {
            notes[currentNote] = new Note(currentNote, date, information);
        } else {
            int newNotebookCapacity = MAGNIFIER * notebookCapacity;
            notes = changeNotebookSize(notebookCapacity, newNotebookCapacity);
            Note note = new Note(currentNote, date, information);
            notes[currentNote] = note;
            notebookCapacity = newNotebookCapacity;
        }
    }

    public void deleteNote(int numToDelete) {
        if (numToDelete > currentNote || numToDelete < 0) {
            System.out.println("There is no note with this number!!!");
        } else {
            System.arraycopy(notes, numToDelete + 1, notes, numToDelete, notebookCapacity - numToDelete - 1);
            notes[currentNote]=null;
            currentNote--;
            for (int i = 0; i < currentNote + 1; i++) {
                notes[i].setNumOfNote(i);
            }
            int newNotebookCapacity = currentNote+3;
            notes = changeNotebookSize(notebookCapacity, newNotebookCapacity);
            notebookCapacity = newNotebookCapacity;
            System.out.println(numToDelete);
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
        while (i <= currentNote) {
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
            System.arraycopy(newNotes, 0, notes, 0, newSize);
        }
        return notes;
    }

}
