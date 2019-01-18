package ibatis2;

import com.ibatis.sqlmap.client.SqlMapClient;

public class WorkerDaoIbatis implements WorkerDao
{
	@Override
	public WorkerTEO addWorker(WorkerTEO worker, SqlMapClient sqlmapClient) {
		try
		{
			Integer id = (Integer)sqlmapClient.queryForObject("worker.getMaxId");
			id = id == null ? 1 : id + 1;
			worker.setId(id);
			sqlmapClient.insert("worker.addWorker", worker);
			worker = getWorkerById(id, sqlmapClient);
			return worker;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public WorkerTEO getWorkerById(Integer id, SqlMapClient sqlmapClient) {
		try
		{
			WorkerTEO worker = (WorkerTEO)sqlmapClient.queryForObject("worker.getWorkerById", id);
			return worker;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void deleteWorkerById(Integer id, SqlMapClient sqlmapClient) {
		try
		{
			sqlmapClient.delete("worker.deleteWorkerById", id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	
}