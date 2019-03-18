package tongji.sse.student.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import tongji.sse.student.dao.ExperienceMapper;
import tongji.sse.student.domain.Experience;

import java.util.ArrayList;

@Service
@Component
public class FileService {
    @Autowired
    ExperienceMapper experienceMapper;

    // To get the max id and return max id+1
    public Integer generationExpId() {
        Integer id = experienceMapper.getMaxId();
        if (id == null) {
            return 1;
        } else {
            return id + 1;
        }
    }

    //store the exp to the db

    public Boolean insertExp(Experience experience) {
        try {
            experienceMapper.insert(experience);
        } catch (Exception e) {
            return false;
        }
        return true;
    }


    public ArrayList<Experience> getAllExperience() {
        return (ArrayList<Experience>)experienceMapper.selectAll();
    }

}
