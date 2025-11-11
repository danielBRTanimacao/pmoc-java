package pmoc.services;

import pmoc.entities.ManagersEntity;

public interface ManagersService {
    void createManager(ManagersEntity data);
    void updtManager(ManagersEntity data);
    void delManager();
}
