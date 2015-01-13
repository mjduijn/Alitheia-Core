package eu.sqooss.impl.service.webadmin;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.velocity.VelocityContext;
import org.osgi.framework.BundleContext;

import eu.sqooss.service.scheduler.Job;

public class JobsView extends AbstractView {

	public JobsView(BundleContext bundlecontext, VelocityContext vc) {
		super(bundlecontext, vc);
	}

	@Override
	public void exec(HttpServletRequest req) {		
	}
	
	/**
	 * Returns the statistics about Failed Jobs.
	 * 
	 * @return HashMap with Failed Jobs stats
	 */
	public static HashMap<String, Integer> getFailedJobStats() {
		return sobjSched.getSchedulerStats().getFailedJobTypes();
	}

	/**
	 * Returns the array of Failed Jobs
	 * 
	 * @return Array of Failed Jobs
	 */
	public static Job[] getFailedJobs() {
		return sobjSched.getFailedQueue();
	}

	/**
	 * Determines whether there is no failed job.
	 * 
	 * @return boolean Is there no failed job?
	 */
	public static boolean isFailedJobsEmpty() {
		Job[] jobs = sobjSched.getFailedQueue();
		if ((jobs != null) && (jobs.length > 0)) {
			return false;
		} else {
			return true;
		}
	}
	
	/**
	 * Returns the statistics about Waiting Jobs.
	 * 
	 * @return HashMap with Waiting Jobs stats
	 */
	public static HashMap<String, Integer> getWaitingJobs() {
		return sobjSched.getSchedulerStats().getWaitingJobTypes();
	}

	/**
	 * Returns List of names of running jobs.
	 * 
	 * @return List of Strings - running jobs names
	 */
	public static List<String> getRunningJobs() {
		return sobjSched.getSchedulerStats().getRunJobs();
	}

}
