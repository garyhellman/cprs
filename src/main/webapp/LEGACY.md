# Legacy ExtJS UI (not used)

This `src/main/webapp` tree (Ext JS 4 + Roo-era admin screens) is **not** part of the
Spring Boot 4 JAR build.

The active UI is the **Angular** app under `apps/review-platform/frontend`, which Maven
builds and packages into `classpath:/static/` and serves at `http://localhost:8080/`.
