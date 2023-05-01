import sys
import os
# from typing import string;

import logging


mainLogger:logging.Logger = logging.getLogger()
# Run python script for debugging

mainLogger.info("-------- Begin test logging -------")

mavenCmd:str = './mvnw'
if sys.platform == "win32":
    mavenCmd = '.\mvnw'

retVal = os.system(f'{mavenCmd} test') # Linux bash run
if retVal != 0: # If failed exit code
    mainLogger.info("Maven Test failed, exiting...")
    sys.exit(1)

mainLogger.info("-------- End test logging -------")

# Build docker image
mainLogger.info("-------- Begin docker build logging -------")
retVal = os.system(f'{mavenCmd} spring-boot:build-image -Dspring-boot.build-image.imageName=demo/payroll')
if retVal != 0:
    mainLogger.error("Docker Build failed, exiting...")
    sys.exit(1)

mainLogger.info("-------- End docker build logging -------")