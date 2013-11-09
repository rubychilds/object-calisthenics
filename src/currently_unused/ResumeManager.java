package currently_unused;

import java.util.ArrayList;
import java.util.HashMap;

import resume.Resume;

public class ResumeManager {

  private final HashMap<JobSeeker, ArrayList<Resume>> resumes;

  public ResumeManager(){
    this.resumes = new HashMap<JobSeeker, ArrayList<Resume>>();	
  }

  public void addResume(JobSeeker js, Resume res){

    ArrayList<Resume> resumeList = new ArrayList<Resume>();
    resumeList = resumes.get(js);

    resumeList.add(res);
    resumes.put(js,  resumeList);
  }

  public void removeResume(JobSeeker js, Resume res){

    ArrayList<Resume> resumeList = resumes.get(js);

    if(resumeList != null)
      resumeList.remove(res);
    // if we get to the stage where no resumes are left we can remove the jobseeker
    if(resumeList.size() == 0)
      resumes.remove(js);
  }

  public ArrayList<Resume> resumeJobSeeker(JobSeeker js){
    return resumes.get(js);

  }


  public int size(){
    return resumes.size();
  }

}
