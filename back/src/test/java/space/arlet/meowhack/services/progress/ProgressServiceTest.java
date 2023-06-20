package space.arlet.meowhack.services.progress;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import space.arlet.meowhack.data.ProgressInfo;
import space.arlet.meowhack.repositories.ProgressRepo;
import space.arlet.meowhack.services.Direction;
import space.arlet.meowhack.services.UserNotFoundException;

import static org.junit.jupiter.api.Assertions.fail;

@ExtendWith(MockitoExtension.class)
public class ProgressServiceTest {

    @Mock
    private ProgressRepo progressRepo;

    @InjectMocks
    private ProgressService progressService;

    @BeforeEach
    public void setup() {
        progressRepo.save(new ProgressInfo(
                0L,
                0L,

                0L,
                0L,

                0L,
                0L,

                0L,
                0L,

                0L,
                0L,

                0L,
                0L,

                0L,
                0L
        ));


    }

    @Test
    public void testOneLevelUpOnDirection() {
        progressService.updateProgress(0, new ExperienceSource() {
            @Override
            public long getExperience() {
                return progressService.tiers[0];
            }

            @Override
            public Direction getDirection() {
                return Direction.ECO;
            }
        });

        assert (progressRepo.findById(0L).get().getLvlEco() == 1L);
    }

    @Test
    public void testOneLevelUp() {
        progressService.updateProgress(0, new ExperienceSource() {
            @Override
            public long getExperience() {
                return progressService.tiers[0];
            }

            @Override
            public Direction getDirection() {
                return Direction.ECO;
            }
        });

        assert (progressRepo.findById(0L).get().getLvl() == 1L);
    }

    @Test
    public void testNoLevelUpOnDirection() {
        progressService.updateProgress(0, new ExperienceSource() {
            @Override
            public long getExperience() {
                return progressService.tiers[0]-50;
            }

            @Override
            public Direction getDirection() {
                return Direction.ECO;
            }
        });

        assert (progressRepo.findById(0L).get().getLvlEco() == 0L);
    }

    @Test
    public void testNoLevelUp() {
        progressService.updateProgress(0, new ExperienceSource() {
            @Override
            public long getExperience() {
                return progressService.tiers[0]-50;
            }

            @Override
            public Direction getDirection() {
                return Direction.ECO;
            }
        });

        assert (progressRepo.findById(0L).get().getLvl() == 0L);
    }

    @Test
    public void testSomeLevelsUp() {
        progressService.updateProgress(0, new ExperienceSource() {
            @Override
            public long getExperience() {
                return progressService.tiers[progressService.tiers.length-1];
            }

            @Override
            public Direction getDirection() {
                return Direction.ECO;
            }
        });

        assert (progressRepo.findById(0L).get().getLvl() == 4L);
    }

    @Test
    public void testSomeLevelsUpOnDirection() {
        progressService.updateProgress(0, new ExperienceSource() {
            @Override
            public long getExperience() {
                return progressService.tiers[progressService.tiers.length-1];
            }

            @Override
            public Direction getDirection() {
                return Direction.ECO;
            }
        });

        assert (progressRepo.findById(0L).get().getLvlEco()== 4L);
    }

    @Test
    public void testLevelsSumUpdate() {
        progressRepo.save(new ProgressInfo(
                0L,
                1L,

                0L,
                0L,

                0L,
                1L,

                0L,
                0L,

                0L,
                0L,

                0L,
                0L,

                0L,
                0L
        ));

        progressService.updateProgress(0, new ExperienceSource() {
            @Override
            public long getExperience() {
                return progressService.tiers[progressService.tiers.length-1];
            }

            @Override
            public Direction getDirection() {
                return Direction.ECO;
            }
        });

        assert (progressRepo.findById(0L).get().getLvl()== 5L);
    }

    @Test
    public void testUserNotFound() {
        try {
            progressService.updateProgress(200, new ExperienceSource() {
                @Override
                public long getExperience() {
                    return progressService.tiers[progressService.tiers.length - 1];
                }

                @Override
                public Direction getDirection() {
                    return Direction.ECO;
                }
            });
        } catch (UserNotFoundException e) {
            return;
        }

        fail();
    }
}
