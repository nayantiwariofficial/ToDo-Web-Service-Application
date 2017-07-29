package dao;

import dto.ToDo;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.List;

public class ToDoDao {

    private Logger logger = LoggerFactory.getLogger(ToDoDao.class);

    public void addTodo(ToDo toDo) {
        logger.info("Trying to Add Todo");
        logger.error("Trying to Add Todo");

        Session session = SessionUtil.getSession();
        Transaction transaction = session.beginTransaction();
        toDo.setDate(LocalDate.now());
        session.save(toDo);
        transaction.commit();
        session.close();
    }

    public void deleteTodo(long id) {
        logger.info("Trying to Delete ID: {}, Param2: {}, P3: {}, P4: {}", id, "P2", "P3", "P4");
        logger.error("Trying to Delete ID: {}, Param2: {}, P3: {}, P4: {}", id, "P2", "P3", "P4");

        Session session = SessionUtil.getSession();
        Transaction transaction = session.beginTransaction();
        ToDo toDo = session.get(ToDo.class, id);
        session.delete(toDo);
        transaction.commit();
        session.close();
    }

    public List<ToDo> getToDos() {
        Session session = SessionUtil.getSession();
        Query query = session.createQuery("FROM ToDo ");
        return (List<ToDo>) query.list();
    }

    public void updateTodo(ToDo toDo) {
        logger.info("Trying to Update ID: {}, Param2: {}, P3: {}, P4: {}", toDo, "P2", "P3", "P4");
        logger.error("Trying to Update ID: {}, Param2: {}, P3: {}, P4: {}", toDo, "P2", "P3", "P4");
        Session session = SessionUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.update(toDo);
        transaction.commit();
        session.close();
    }

    public ToDo getToDo(Long id) {
        Session session = SessionUtil.getSession();
        Transaction transaction = session.beginTransaction();
        ToDo toDo = session.get(ToDo.class, id);
        transaction.commit();
        session.close();
        return toDo;
    }

}
