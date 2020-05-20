package entity;

public class EmplProj {
	private long employeeId;
	private long projectID;
	
	public EmplProj() {
		// TODO Auto-generated constructor stub
	}

	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	@Override
	public String toString() {
		return "EmplProj [employeeId=" + employeeId + ", projectID=" + projectID + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (employeeId ^ (employeeId >>> 32));
		result = prime * result + (int) (projectID ^ (projectID >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmplProj other = (EmplProj) obj;
		if (employeeId != other.employeeId)
			return false;
		if (projectID != other.projectID)
			return false;
		return true;
	}

	public long getProjectID() {
		return projectID;
	}

	public void setProjectID(long projectID) {
		this.projectID = projectID;
	}
	
	
}
