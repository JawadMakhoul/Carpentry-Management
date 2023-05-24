import datetime
import configparser
import os
import sys
import logging
from base64 import b64decode
import openai
from openai.error import InvalidRequestError

# Set up logging
logging.basicConfig(level=logging.INFO)

def generate_image(prompt, num_image=1, size='512x512', output_format='url'):
    """
    params:
        prompt (str):
        num_image (int):
        size (str):
        output_format (str):
    """
    try:
        images = []
        # OpenAI Image API does not exist as of my knowledge cutoff in 2021.
        response = openai.Image.create(
            prompt=prompt,
            n=num_image,
            size=size,
            response_format=output_format
        )
        if response is not None:
            for image in response['data']:
                images.append(image.url if output_format == 'url' else image.b64_json)
            return {'created': datetime.datetime.fromtimestamp(response['created']), 'images': images}
        else:
            logging.error("Response is None. Check your OpenAI account or the status of your API call.")
            return None
    except InvalidRequestError as e:
        logging.error(e)
        return None
    except Exception as e:
        logging.error("Unexpected error: ", exc_info=True)
        return None

#config = configparser.ConfigParser()
#config.read('credential.ini')


#API_KEY = config['openai']['APIKEY']
print("jawad")
openai.api_key = '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'
print("makhoul")
SIZES = ('1024x1024', '512x512', '256x256')

# Get image description from user
image_description = sys.argv[1]
print("21342134234")
# Specify the folder where you want to save the images
output_folder = os.path.join("C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib\\images")
print("2")
# Generate images (byte output)
response = generate_image(image_description, num_image=10, size=SIZES[1], output_format='b64_json')
if response is not None:
    prefix = 'demo'
    for indx, image in enumerate(response['images']):
        # Combine the output folder path with the file name
        output_path = os.path.join(output_folder, f"{prefix}_{indx+1}.jpg")
        with open(output_path, 'wb') as f:
            f.write(b64decode(image))
    logging.info(f"Images successfully saved in {output_folder}")
else:
    logging.error("Failed to generate byte images.")
print("3")
