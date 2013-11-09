package applications;

import java.util.ArrayList;
import java.util.List;

import jobs.Job;
import jobseeker.Jobseeker;

public class ApplicationProcess
{

  private List<Application> applications;

  public ApplicationProcess()
  {
    this.applications = new ArrayList<>();
  }
  
  public void apply(Jobseeker jobseeker,
                    Job job)
  {
    Application application = new Application(jobseeker, job);
    applications.add(application);
    
  }

}
