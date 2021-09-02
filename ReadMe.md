# jk8ps-mvn-archetype

This is a repository for maven archetype for josdk 

Currently the default archetype is :

- default

You can build it locally with :

```bash
cd default &&\
mvn install \ 
    archetype:update-local-catalog
```

then create your new java operator project with :

```bash
mvn archetype:generate \
    -DarchetypeGroupId=io.github.shyrkaio.archetypes \                       -DarchetypeArtifactId=default \
    -DarchetypeVersion=0.0.1-SNAPSHOT \
    -DgroupId=io.github.shyrkaio.sample \
    -DartifactId=foo-sample \
    -Dcrd-name=MyGreatCRD \ 
    -Dversion=1.0-SNAPSHOT 
```

Those parameter are define by your project.

```bash
    -DgroupId=xxxxx \
    -DartifactId=xxxxx \
    -Dcrd-name=xxxxxx \ 
    -Dversion=sssss 
```