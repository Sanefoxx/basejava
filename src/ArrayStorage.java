import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int size = 0;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void update(Resume r){
        if (!Arrays.asList(storage).contains(r)) {
            System.out.println("This resume not in storage to update");
        } else {
            for (int i = 0; i < size; i++) {
                if (r.getUuid().equals(storage[i].getUuid())) {
                    storage[i] = r;
                }
            }
        }
    }

    public void save(Resume r) {
        if (size >= storage.length) {
            System.out.println("Переполнение хранилища");
        } else if (!Arrays.asList(storage).contains(r)) {
            storage[size] = r;
            size++;
        } else {
            System.out.println("This resume already in storage");
        }
    }

    public Resume get(String uuid) {
        if (!checkIndex(uuid)) {
            System.out.println("This resume not in storage to get");
            return null;
        } else {
            for (int i = 0; i < size; i++) {
                if (uuid.equals(storage[i].getUuid())) {
                    return storage[i];
                }
            }
            return null;
        }
    }

    public void delete(String uuid) {
        if (!checkIndex(uuid)) {
            System.out.println("This resume not in storage to delete");
        } else {
            for (int i = 0; i < size; i++) {
                if (uuid.equals(storage[i].getUuid())) {
                    size--;
                    storage[i] = storage[size];
                    storage[size] = null;
                }
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */

    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public boolean checkIndex(String uuid) {
        String[] array = new String[size];
        for (int i = 0; i < size; i++) {
            array[i] = storage[i].getUuid();
        }
        return Arrays.asList(array).contains(uuid);
    }

    public int size() {
        return size;
    }
}
