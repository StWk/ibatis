package ibatis2.MainClass;

import java.io.Reader;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import java.sql.SQLException;

import ibatis2.WorkerDao;
import ibatis2.WorkerDaoIbatis;
import ibatis2.WorkerTEO;

public class TestMain 
{
	public static void main(String[] args) throws Exception
	{
		//Initialize dao
		WorkerDao manager = new WorkerDaoIbatis();

		//Create the SQLMapClient
		
		Reader reader = Resources.getResourceAsReader("sqlMapConfig.xml");
		SqlMapClient sqlmapClient = SqlMapClientBuilder.buildSqlMapClient (reader);
		
		try {
			sqlmapClient.startTransaction();

		//Create a new user to persist
		WorkerTEO worker = new WorkerTEO();
		worker.setId(1);
		worker.setName("park");

		//Add the user
		manager.addWorker(worker,sqlmapClient);

		//Fetch the user detail
		WorkerTEO createdWorker = manager.getWorkerById(1, sqlmapClient);
		System.out.println(createdWorker.getName());

		//int testint = 1/0;
		//Lets delete the user
		//manager.deleteWorkerById(1, sqlmapClient);
			sqlmapClient.commitTransaction();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			sqlmapClient.endTransaction();
		}
	}
}