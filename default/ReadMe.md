# Maven Archetype for JOSDK

## Install

```bash
git clone https://github.com/shyrkaio/jk8ps-mvn-archetype.git && \
cd jk8ps-mvn-archetype\default && \
mvn clean install archetype:update-local-catalog

```

## create a default project

```bash
mvn archetype:generate -DarchetypeGroupId=io.github.shyrkaio.archetypes \
                                        -DarchetypeArtifactId=default \
                                        -DarchetypeVersion=0.0.1-SNAPSHOT \
                                        -DgroupId=io.github.shyrkaio.sample \
                                        -DartifactId=tom \
                                        -Dversion=1.0-SNAPSHOT \
                                        -Dcrd-name=Tom \
                                        -Dcrd-name-lowercase=tom
```