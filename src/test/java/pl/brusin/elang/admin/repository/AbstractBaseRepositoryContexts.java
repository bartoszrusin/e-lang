package pl.brusin.elang.admin.repository;

import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
    "classpath:spring/ci-config-context.xml",
    "classpath:spring/hibernate-jpa-context.xml"
})
@ActiveProfiles("ci")
@Transactional
public abstract class AbstractBaseRepositoryContexts {
}
