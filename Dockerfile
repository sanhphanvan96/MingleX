FROM maven:3.5-jdk-8

# Build source -> java application
COPY ./app /app
WORKDIR /app
RUN mvn -Dmaven.test.skip=true install

# Install some python packages(Todo: need build another image that has these package first)
WORKDIR /tmp
RUN curl https://bootstrap.pypa.io/get-pip.py -o get-pip.py
RUN python get-pip.py
RUN apt update -y
RUN apt install python-dev libpq-dev -y
RUN apt-get install python-mysqldb -y

# Python script for run later
COPY ./wait-for-mysql.py /tmp/wait-for-mysql.py
