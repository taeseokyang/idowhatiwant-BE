package yang.idowhatiwant.domain.text.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import yang.idowhatiwant.domain.text.domain.Text;

import java.util.List;

@Repository
@Transactional
public interface TextRepository extends JpaRepository<Text, Long> {
    List<Text> findAllByOrderByDate();
}
