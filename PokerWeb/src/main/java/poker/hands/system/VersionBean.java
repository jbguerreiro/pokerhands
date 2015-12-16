package poker.hands.system;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import lombok.Getter;
import lombok.Setter;

@ManagedBean
@ApplicationScoped
public class VersionBean {

	@Getter
	@Setter
	private String deployVersion;

	@Getter
	@Setter
	private String buildNumber;

	@Getter
	@Setter
	private String buildTimestamp;

	@PostConstruct
	private void init() {
		deployVersion = Version.DEPLOY_VERSION;
		buildNumber = Version.BUILD_NUMBER;
		buildTimestamp = Version.BUILD_TIMESTAMP;
	}
}
