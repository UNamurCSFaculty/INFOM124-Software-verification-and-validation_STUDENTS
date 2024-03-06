# Run

```bash
mvn clean verify sonar:sonar \
  -Dsonar.projectKey=GildedRose \
  -Dsonar.projectName='GildedRose' \
  -Dsonar.host.url=http://localhost:9000 \
  -Dsonar.token=sqp_b9940cfe9ab5662ca51fa48a8b9981d2b6ddddc5
  -Pcoverage
```
