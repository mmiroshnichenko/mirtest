package lesson19.home;

public class Controller {
    void put(Storage storage, File file) {
        try {
            storage.validateNewFile(file);
            storage.put(file);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    void delete(Storage storage, File file) {
        try {
            storage.delete(file);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    void transferAll(Storage storageFrom, Storage storageTo) {
        try {
            storageTo.validateNewPacketFiles(storageFrom.getFiles());
            for (File file : storageFrom.getFiles()) {
                storageTo.put(file);
                storageFrom.delete(file);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    void transferFile(Storage storageFrom, Storage storageTo, long id) {
        try {
            File file = storageFrom.getFileById(id);
            put(storageTo, file);
            delete(storageFrom, file);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
