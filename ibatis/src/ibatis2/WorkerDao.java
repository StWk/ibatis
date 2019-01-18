package ibatis2;

import com.ibatis.sqlmap.client.SqlMapClient;

public interface WorkerDao {
      public WorkerTEO addWorker(WorkerTEO worker, SqlMapClient sqlmapClient);
      public WorkerTEO getWorkerById(Integer id, SqlMapClient sqlmapClient);
      public void deleteWorkerById(Integer id, SqlMapClient sqlmapClient);
}