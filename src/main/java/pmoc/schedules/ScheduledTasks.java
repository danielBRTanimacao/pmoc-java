package pmoc.schedules;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pmoc.repositories.ManagersRepository;

@Component
@RequiredArgsConstructor
public class ScheduledTasks {

    private final ManagersRepository managersRepository;

    @Scheduled(cron = "0 0 * * * *")
    public void checkExpiredManagers() {
        managersRepository.findAll().forEach(managers -> {
            if (managers.isExpiredToken()) {
                if (!managers.getToken().equals("VALID")) {
                    managersRepository.delete(managers);
                }
            }
        });
    }
}
