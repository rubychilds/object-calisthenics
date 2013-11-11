package applications;

import java.util.HashMap;

import jobseeker.Jobseeker;

public class ApplicationRepository
{
  private HashMap<Jobseeker, Applications> applications;

  public ApplicationRepository()
  {
    this.applications = new HashMap<>();
  }

  public void addApplication(Jobseeker jobseeker,
                             Application application)
  {
    Applications applicationsForJobseeker = applications.get(jobseeker);
    if (applicationsForJobseeker == null)
      applicationsForJobseeker = new Applications();

    applications.put(jobseeker, applicationsForJobseeker);
  }

  public Applications viewApplications(Jobseeker jobseeker)
  {
    return applications.get(jobseeker);
  }

}
