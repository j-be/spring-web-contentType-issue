plugins {
	java
}

group = "org.duckdns.owly.spring.issues"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_21
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web:3.2.3")
	testImplementation("org.springframework.boot:spring-boot-starter-test:3.2.3")
}


configurations.configureEach {
// Uncomment section below to force spring-web 6.1.3
//	resolutionStrategy.force("org.springframework:spring-web:6.1.3")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
